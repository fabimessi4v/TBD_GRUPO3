<script setup>
import axios from 'axios'
import { ref } from 'vue'

const availableDataset = ref([])
const mostrarLista = ref(false)

const fetchListReportSummary = async () => {
  try {
    const url = import.meta.env.VITE_BASE_URL + '/api/resumensemanal/obtenerListaResumen'
    const response = await axios.get(url)
    availableDataset.value = response.data
    mostrarLista.value = true
  } catch (error) {
    console.error(error)
    alert('Error al recuperar los datos del reporte semanal: ' + error.message)
  }
}

const ocultarLista = () => {
  mostrarLista.value = false
  availableDataset.value = []
}
</script>

<template>
  <div>
    <h3>Reporte semanal</h3>

    <div class="button-container">
      <button 
        v-if="!mostrarLista" 
        @click="fetchListReportSummary" 
        class="btn-cargar">
        Cargar reporte de todos los datasets
      </button>

      <button 
        v-else 
        @click="ocultarLista" 
        class="btn-cargar">
        Ocultar reporte
      </button>
      <router-link to="/resumensemanalporid" class="btn-cargar">
        Resumen semanal por id
      </router-link>
    </div>

    <ul v-if="mostrarLista && availableDataset.length">
      <li v-for="objeto in availableDataset" :key="objeto.idDataset" class="report-item">
        <div class="report-details">
          <span class="report-info">ID Dataset: {{ objeto.idDataset }}</span><br>
          <span class="report-info">Semana: {{ objeto.semana }}</span><br>
          <span class="report-info">Promedio: {{ objeto.promedio }}</span>
        </div>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.button-container {
  display: flex;
  justify-content: center;
  gap: 20px;
  margin-bottom: 20px;
}

.btn-cargar {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px 16px;
  border-radius: 6px;
  cursor: pointer;
}

.btn-cargar:hover {
  background-color: #0056b3;
}

.report-item {
  background: #f8f9fa;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 6px;
  list-style: none;
  border: 1px solid #ddd;
}

.report-info {
  display: block;
  color: #333;
}
</style>

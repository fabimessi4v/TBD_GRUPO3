<script setup>
import axios from 'axios'
import { ref } from 'vue'

const availableDataset = ref([])
const mostrarLista = ref(false)
const mostrarIngresarId = ref(false)
const idDataset = ref('')

const limpiarPantalla = () => {
  mostrarLista.value = false
  availableDataset.value = []
}

const fetchListReportSummary = async () => {
  limpiarPantalla()
  mostrarIngresarId.value = false
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

const fetchListById = async () => {
  limpiarPantalla()
  try {
    if (!idDataset.value) {
      alert('Debes ingresar un ID de dataset.')
      return
    }
    const url = import.meta.env.VITE_BASE_URL + '/api/resumensemanal/obtenerListaResumenEspecifico/' + idDataset.value
    const response = await axios.get(url)
    availableDataset.value = response.data
    mostrarLista.value = true
  } catch (error) {
    console.error(error)
    alert('Error al recuperar el dataset: ' + error.message)
  }
}

const updateListById = async () => {
  limpiarPantalla()
  try {
    if (!idDataset.value) {
      alert('Debes ingresar un ID de dataset.')
      return
    }
    const url = import.meta.env.VITE_BASE_URL + '/api/resumensemanal/recalcularResumen/' + idDataset.value
    await axios.post(url)
    alert('Resumen recalculado exitosamente para el dataset ' + idDataset.value)
  } catch (error) {
    console.error(error)
    alert('Error al recalcular el resumen: ' + error.message)
  }
}

const updateListByIdAndShow = async () => {
  limpiarPantalla()
  try {
    if (!idDataset.value) {
      alert('Debes ingresar un ID de dataset.')
      return
    }
    const url = import.meta.env.VITE_BASE_URL + '/api/resumensemanal/recalcularResumenyObtener/' + idDataset.value
    const response = await axios.post(url)
    availableDataset.value = response.data
    mostrarLista.value = true
  } catch (error) {
    console.error(error)
    alert('Error al recalcular y obtener el resumen: ' + error.message)
  }
}

const mostrarCampoId = () => {
  limpiarPantalla()
  mostrarIngresarId.value = true
}
</script>

<template>
  <div>
    <h3>Reporte semanal</h3>

    <div class="button-container">
      <button @click="fetchListReportSummary" class="btn-cargar">
        Reporte de todos los datasets
      </button>

      <button @click="mostrarCampoId" class="btn-cargar">
        Resumen semanal por ID
      </button>
    </div>

    <div v-if="mostrarIngresarId" class="input-container">
      <input v-model="idDataset" type="number" placeholder="Ingrese ID del dataset" class="input-id" />
      <button @click="fetchListById" class="btn-cargar">Buscar</button>
      <button @click="updateListById" class="btn-cargar">Recalcular</button>
      <button @click="updateListByIdAndShow" class="btn-cargar">Recalcular y Mostrar</button>
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

    <button 
      v-if="mostrarLista" 
      @click="limpiarPantalla" 
      class="btn-ocultar">
      Ocultar reporte
    </button>

    <router-link to="/seleccion" class="btn-volver">
        Volver al menu de seleccion
    </router-link>

  </div>
</template>

<style scoped>
.button-container {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
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

.btn-ocultar {
  position: fixed;
  top: 20px;
  right: 20px;
  background-color: #dc3545;
  color: white;
  border: none;
  padding: 10px 16px;
  border-radius: 6px;
  cursor: pointer;
}

.btn-volver {
  position: fixed;
  top: 40px;
  left: 20px;
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px 16px;
  border-radius: 6px;
  cursor: pointer;
}

.btn-ocultar:hover {
  background-color: #a71d2a;
}

.input-container {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 10px;
  margin-bottom: 20px;
}

.input-id {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 6px;
  width: 220px;
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

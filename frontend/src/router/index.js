import { h, resolveComponent } from 'vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import DefaultLayout from '@/layouts/DefaultLayout.vue'

const routes = [
  // Login fuera del layout
  {
    path: '/',
    name: 'Login',
    component: () => import('@/views/pages/Login.vue')
  },
  // Rutas con layout
  {
    path: '/',
    component: DefaultLayout,
    children: [
      {
        path: 'dashboard',
        name: 'Dashboard',
        component: () => import('@/views/dashboard/Dashboard.vue')
      },
      { 
        path: 'seleccion',
        name: 'Seleccion',
        component: () => import('@/views/pages/Seleccion.vue')
      },
      {
        path: 'resumenSemanal',
        name: 'ResumenSemanal',
        component: () => import('@/views/pages/ResumenSemanal.vue')
      },
      {
        path: 'agregaciondedatos',
        name: 'AgregacionDeDatos',
        component: () => import('@/views/pages/AgregacionDeDatos.vue')
      },
      {
        path: 'correlacion-espacial',
        name: 'Correlacion Espacial',
        component: () => import('@/views/pages/correlacion-espacial.vue')
      },
       {
        path: 'deteccion-eventos-extremos',
        name: 'Deteccion de eventos extremos',
        component: () => import('@/views/pages/deteccion-eventos-extremos.vue')
      },
      {
        path: '/tendencia-mensual',
        name: 'TendenciaMensual',
        component: () => import('@/views/pages/TendenciaMensual.vue')
      },
      {
        path: '/georreferencia',
        name: 'Georreferencia',
        component: () => import('@/views/pages/Georreferencia.vue')
      }
    ]
  }

]

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes,
  scrollBehavior() {
    return { top: 0 }
  }
})

export default router

import { h, resolveComponent } from 'vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import DefaultLayout from '@/layouts/DefaultLayout.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: () => import('@/views/pages/Login.vue')
  },
  {
    path: '/seleccion',
    name: 'Seleccion',
    component: () => import('@/views/pages/Seleccion.vue')
  },
  {
    path: '/resumenSemanal',
    name: 'ResumenSemanal',
    component: () => import('@/views/pages/ResumenSemanal.vue')
  },
  {
    path: '/agregaciondedatos',
    name: 'AgregacionDeDatos',
    component: () => import('@/views/pages/AgregacionDeDatos.vue')
  },
  {
    path: '/dashboard',
    name: 'Home',
    component: DefaultLayout,
    children: [
      {
        path: '',
        name: 'Dashboard',
        component: () => import('@/views/dashboard/Dashboard.vue')
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

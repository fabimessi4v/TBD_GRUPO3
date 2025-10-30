export default [
  {
    component: 'CNavItem',
    name: 'Dashboard',
    to: '/dashboard',
    icon: 'cil-speedometer',
    badge: { color: 'primary' },
  },
  {
    component: 'CNavItem',
    name: 'Correlacion espacial',
    to: '/correlacion-espacial',
    icon: 'cil-calculator',
    badge: { color: 'primary' },
  },
  {
    component: 'CNavItem',
    name: 'Eventos extremos',
    to: '/deteccion-eventos-extremos',
    icon: 'cil-search',
    badge: { color: 'primary' },
  },
  {
    component: 'CNavItem',
    name: 'Resumen Semanal',
    to: '/ResumenSemanal',
    icon: 'cil-chart',
    badge: { color: 'primary' },
  },

  {
  component: 'CNavItem',
  name: 'Obtener serie temporal',
  to: '/agregaciondedatos',
  icon: 'cil-storage',
  badge: { color: 'primary' },
  }

]
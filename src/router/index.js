import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: () => import('@/App')
    },
    {
      path: '/content',
      component: () => import('@/views/content')
    },
    {
      path: '/lulu',
      component: () => import('@/views/lulu')
    },
    {
      path: '/sunshen',
      component: () => import('@/views/sunshen')
    }
  ]
})

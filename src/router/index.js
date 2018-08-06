import Vue from 'vue'
import Router from 'vue-router'
import App from '@/App'
import index from '@/components/index'
import lulu from '@/components/lulu'
import sunshen from '@/components/sunshen'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: App
    },
    {
      path: '/index',
      component: index
    },
    {
      path: '/lulu',
      component: lulu
    },
    {
      path: '/sunshen',
      component: sunshen
    }
  ]
})

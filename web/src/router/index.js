import Vue from 'vue'
import Router from 'vue-router'
import Recruiters from '@/components/Recruiters'
import Personals from '@/components/Personals'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Recruiters',
      component: Recruiters
    },
    {
      path: '/personal',
      name: 'Personals',
      component: Personals
    }
  ]
})

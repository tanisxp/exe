import Vue from 'vue'
import App from './App.vue'
import router from './router'

import VueTailwindPicker from 'vue-tailwind-picker'

Vue.config.productionTip = false
Vue.use(VueTailwindPicker)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

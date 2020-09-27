import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
//引入nprogress
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

// 简单配置
NProgress.inc(0.2)
NProgress.configure({ easing: 'ease', speed: 500, showSpinner: false })

router.beforeEach((to,from,next) => {
  NProgress.start()
  next()})

router.afterEach(() => {
  NProgress.done()
})


Vue.config.productionTip = false
Vue.use(Antd);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

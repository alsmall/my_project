// 导入全局引入都在main.js中导入
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/css/global.css'// 全局引入样式
import './assets/font/iconfont.css'//全局引入font，样式
import './plugins/element.js'  //全局引入elementUI框架，通过我们编写的element.js文件引入
import axios from 'axios'//全局导入，跨域操作

Vue.config.productionTip = false
Vue.prototype.$http=axios   // 挂载axios到Vue的原型prototype的$http
axios.defaults.baseURL="http://localhost:9000"  // 设置请求的根路径   

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

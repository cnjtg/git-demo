/**
 * 入口JS 创建Vue实例
 */

import Vue from "vue";
import App from "./App";
import axios from  "axios";
import ElementUI from "element-ui";
import  'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
axios.defaults.baseURL = '/api'  //关键代码


Vue.use(ElementUI)
Vue.prototype.$http = axios;
Vue.prototype.$bus = new Vue();

new Vue({
  el: "#app",
  components: {
    App
  },
  template: "<App/>"
})

/**
 * 入口JS 创建Vue实例
 */

import Vue from "vue";
import App from "./App";
import axios from  "axios";

Vue.config.productionTip = false
axios.defaults.baseURL = '/api'  //关键代码

Vue.prototype.$http = axios;
Vue.prototype.$bus = new Vue();
new Vue({
  el: "#app",
  components: {
    App
  },
  template: "<App/>"
})

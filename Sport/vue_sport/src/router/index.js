import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import Debug from '../components/Debug.vue'
import UserList from '../components/admin/UserList.vue'

Vue.use(Router)

// 配置路由
const router= new Router({
  routes:[
    {
      path: '/',
      redirect:'/login'
    },
    {
      path: '/login',
      component: Login
    },
    {
      path:'/debug',
      component:Debug,
    },
    
    {
      // 当触发二级路由时，此路由就会将对应内容传给自己父级路由组件里的router-view中显示
      path:'/home',
      component:Home,
      redirect:'/welcome',
      children:[
        {
          path:'/user',
          component:UserList,     
        },  
        {
          path:'/welcome',
          component:Welcome,
        },  
      ]
    }
  ]
})
//配置路由导航守卫（没有登录进不来）
router.beforeEach((to, from, next) => {
  // to:将要访问的路径
  // from:从哪里访问的路径
  // next:重定向到next(url)上，如果是next()继续访问to的路径
  // next（）放行， next（'/URL'）强制跳转的路径。
  if (to.path =='/login') return next();// 访问路径为登录
  // 获取flag
  const flagStr = window.sessionStorage.getItem("flag");// session取值
  console.log(flagStr);
  if (!flagStr) return next('/login');// 没登录去登录
  next();
})
//暴露出去
export default router
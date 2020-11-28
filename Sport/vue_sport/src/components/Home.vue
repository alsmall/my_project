<template>
  <!-- 有了container就不能用div了 -->
  <!-- 引入container布局头部 -->
  <el-container class="home-container">
    <!-- 头部 -->
    <el-header class="el-header">
      <div>
        <img src="../assets/logo.png" alt class="logo-img" />
        <span>运动管理平台</span>
      </div>
      <el-button type="info" @click="logout">安全退出</el-button>
    </el-header>
    <!-- 主题 -->
    <el-container>
      <!-- 侧边栏 -->
      <el-aside class="el-aside" :width="isCollapse ?'64px':'200px'">
          <!--折叠按钮 -->
        <div class="toggle-button" @click="toggleCollapase">|||</div>  
        <!-- 导航栏一 -->
        <el-menu class="el-menu" background-color="#545c64" text-color="#fff" active-text-color="#409eff"
        :collapse="isCollapse" :collapse-transition="false" :router="true" >
          <!-- 一级菜单:一层遍历 -->
          <el-submenu :index="item.id+''" v-for="item in menulist" :key="item.id">
            <template slot="title">
              <i :class="iconsObject[item.id]"></i>
              <span>{{item.title}}</span>
            </template>
            <!-- 二级菜单：二层遍历 -->
            <el-menu-item :index="it.path" v-for="it in item.slist" :key="it.id" >
                <i :class="iconsObject[it.id]"></i>
                <span >{{it.title}}</span>
            </el-menu-item>
          </el-submenu>

          <!-- 导航栏二 -->
          <el-menu-item index="2" disabled>
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>

          <!-- 导航栏三 -->
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>

          <!-- 导航栏四 -->
          <el-menu-item index="4" disabled>
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <!-- 主题内容 -->
      <el-main class="el-main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data(){
      return{
          //菜单列表
          menulist:[],
          //按钮伸缩
          isCollapse: false,
          //导航栏图标
          iconsObject: {
              '100':'iconfont icon-guanliyuan',
              '200':'iconfont icon-yundong',
              '101':'iconfont icon-denglu',
              '102':'iconfont icon-password',
              '103':'iconfont icon-yundong',
              '104':'iconfont icon-shangpin',
              '201':'iconfont icon-shu',
              '202':'iconfont icon-qialuli',
              '203':'iconfont icon-shiwu-',
              '204':'iconfont icon-denglu',
              },
      }
  },
  created(){
      //查询menuList
      this.getMenuList();
  },
  //created方法：页面已加载就执行  
  methods: {
    //退出按钮方法
    logout() {
      window.sessionStorage.clear; //清除session，保证安全
      this.$router.push("/login"); //页面路由跳转
    },
    // 获取所有的导航菜单(从后台取数据)
    async getMenuList(){
      const {data:res} = await this.$http.get("menus");
      console.log(res.data);
      if( res.status != 200) return this.$message.error("操作失败！！！");
      this.menulist = res.data;//数据回填到 menulist:[]
    },
    //折叠按钮
    toggleCollapase(){
        this.isCollapse=!this.isCollapse;
    },
  },
};
</script>
<style lang="less" scoped>
//总体布局样式
.home-container {
  height: 100%;
}
// 头部样式
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between; // 左右贴边
  padding-left: 0%; // 左边界
  align-items: center; // 水平
  color: #fff; //字体颜色
  font-size: 20px; //字体大小
  //左侧div加布局
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}
// 侧边栏样式
.el-aside {
  background-color: #333744;
  .el-menu{
    border-right: none;// 对其右边框
  }
}
// 主题样式
.el-main {
  background-color: #eaedf1;
}
// 头部图片样式
.logo-img {
  width: 55px;
  height: 55px;
}
// 伸缩按钮样式
.toggle-button{
  background-color:#4A5064;
  font-size: 10px;
  line-height: 24px;
  color:#fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;// 显示鼠标指针为：小手
}

</style>
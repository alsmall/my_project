<template>
    <!-- 根容器 -->
    <div class="login_container">
        <!-- 登录模块 -->
        <div class="login_box">
            <!-- 头像框 -->
            <div class="avatar_box">
                <img src="../assets/logo.png">
            </div>
            <!-- 表单区域 -->
            <!-- 提交的时候绑定loginForm中的数据 -->
            <el-form class="login_form" ref="loginFormRef" :model="loginForm" :rules="loginRules"  label-width="0">
                <!-- 用户名 -->
                <el-form-item prop="username">
                    <!-- 绑定loginForm中的数据 -->
                    <el-input v-model="loginForm.username" prefix-icon="iconfont icon-denglu"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" type='password' prefix-icon="iconfont icon-password"></el-input>
                </el-form-item>
                <!-- 按钮 ：使用@click给按钮添加函数-->
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">提交</el-button>
                    <el-button type="info" @click=" resetLoginForm">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
<script>

export default {
    // 数据绑定
    data(){
        return{
            // 表单数据
            loginForm:{
                username:"admin",
                password:"12345678"
            },
            // 校验规则
            loginRules:{
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                    ],
                password: [
                    { required: true, message: '请选输入密码', trigger: 'change' },
                     { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
                    ],
            }
        };

    },
    // 函数绑定
    methods:{
        // 登录方法
        login(){
           //console.log("aismall");
           //验证校验规则
           this.$refs.loginFormRef.validate(async valid=>{
               if(!valid) return;//验证失败
                //当成功提交之后就进行路由转发，将返回的值存到data的res中    
                //const {data :res} = await this.$http.post("test");
                // 将返回的值打印到控制台    
                //console.log(res);
                const {data :res} = await this.$http.post("login",this.loginForm);//访问后台
                if(res=="ok"){
                    window.sessionStorage.setItem('flag','ok'); // session 放置
                    this.$message.success("登录成功！！！！");//信息提示
                    this.$router.push({path:"/home"});//页面路由跳转
                }else{
                    this.$message.error("登录失败！！！");//错误提示
                }
            });
        },
        resetLoginForm(){
            //console.log(66666);
            // 重置表单内容函数
            this.$refs.loginFormRef.resetFields();
        }
    }

}
</script>

<style lang="less" scoped>
// 根节点样式(全覆盖)
.login_container{
    background-color: #2b4b6b;
    height: 100%;
}
//登录框样式
.login_box{
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;// 圆角
    position: absolute;// 绝对定位
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);// 根据自己位置 以自己为长度位移

    // 头像框样式
    .avatar_box {
        width: 160px;
        height: 160px;
        border: 1px solid #eee;
        border-radius: 50%; // 加圆角
        padding: 10px;
        box-shadow: 0 0 10px #ddd;// 盒子阴影
        position: absolute;// 绝对定位
        left: 50%;
        transform: translate(-50%, -50%);// 根据自己位置 以自己为长度位移
        background-color: rgb(66, 218, 218);
        img {
        width: 100%;
        height: 100%;
        border-radius: 50%; // 加圆角
        background-color: #eee;
        }
    }
    // 表单区域样式  
    .login_form {
        position: absolute;
        bottom: 0%;
        width: 100%;
        padding: 0 10px;
        box-sizing: border-box;// 设置边框
    }
    // 按钮样式
    .btns {
        display: flex;// 弹性布局
        justify-content: flex-end; // 尾部对齐
    }
}
</style>

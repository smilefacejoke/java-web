<template>
  <div class="home">
    <el-container>
      <el-header>
        <span class="zelin" v-html="content"></span>
        <div :class="arrowclass" @click="updateWidth" :style="mystyle"></div>
        <span style="float:right">Vue + ElementUI + Servlet + Mabatis + Maven整合开发</span>
      </el-header>
      <el-container>
        <el-aside :width="width">
          <el-menu
                  default-active="2"
                  background-color="#545c64"
                  text-color="#fff"
                  router
                  :collapse-transition="false"
                  :collapse="collapse"
                  :default-active="this.$route.path"
                  active-text-color="#ffd04b"
                  class="el-menu-vertical-demo">

            <el-submenu :index="menu.path" v-for="menu in menus">
              <template slot="title">
                <i :class="menu.icon"></i>
                <span>{{menu.title}}</span>
              </template>

              <el-menu-item :index="menu.path + child.path" v-for="child in menu.children">
                <i :class="child.icon"></i>
                <span slot="title">{{child.title}}</span>
              </el-menu-item>
            </el-submenu>

          </el-menu>

        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script>
  import menus from "../assets/menu";
  export default {
    name: 'Home',
    data(){
      return {
        menus:menus,
        width:'200px',
        collapse:false,
        arrowclass:'el-icon-s-fold',
        content:"<span class='zl-inner'>涛哥</span> 开发平台",
        mystyle:'float:left;margin-top: 25px;margin-left: 65px;'
      }
    },
    created() {

    },
    methods:{
      updateWidth(){
        if(this.width === '200px'){
          this.width = '60px';
          this.collapse = true;
          this.content = "<span class='zl-inner'>涛哥</span>"
          this.arrowclass = "el-icon-s-unfold"
          this.mystyle = 'float:left;margin-top: 25px;margin-left: 5px;'
        }else{
          this.width = '200px';
          this.collapse = false;
          this.content = "<span class='zl-inner'>涛哥</span> 开发平台";
          this.arrowclass = "el-icon-s-fold"
          this.mystyle = 'float:left;margin-top: 25px;margin-left: 65px;'
        }
      }
    },
    components: {

    }
  }
</script>

<style>
  *{
    padding:0;
    margin:0;
  }
  .zelin{
    color:white;
    font: 18px 微软雅黑 ;
    float:left;
    margin-top: 20px;
    margin-left: -10px;
  }
  .zl-inner{
    font: 22px 华文行楷;
    color: orange;
  }
  .el-menu-item{
    margin-left: 12px;
  }
  .el-header, .el-footer {
    background-color: rgb(84,92,100);
    color: white;
    line-height: 60px;

  }
  .el-menu{
    border-right: 0;
  }
  .el-aside {
    background-color: rgb(84,92,100);
    color: #333;
    text-align: center;
    line-height: 10px;
    height: 800px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 20px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>

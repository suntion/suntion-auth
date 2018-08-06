<template>
  <div id="nav" :style="navHeight">
    <el-scrollbar style="height:100%;overflow-x:hidden">
      <el-menu default-active="1" class="el-menu-vertical-demo" :router="true">
        <el-menu-item index="/index">消息中心</el-menu-item>
        <el-submenu index="" show-timeout=50 hide-timeout=50>
          <template slot="title">权限管理</template>
          <el-menu-item index="/sunshen">
            <i class="el-icon-error"/>sunshen
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
          <el-menu-item index="/lulu">
            <i class="el-icon-error"/>lulu
          </el-menu-item>
        </el-submenu>
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
export default {
  name: "Nav",
  data(){
    return {
    }
  },
  computed:{
     navHeight () {
      return {
        height: (window.innerHeight - 80) + 'px'
      }
    },
  }
};
</script>

<style>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 300px;
    min-height: 800px;
  }
</style>

<template>
  <div id="app">
    <el-container direction="vertical">
        <el-container>
          <el-aside>
            <el-scrollbar :style="navHeight" >
              <Nav />
            </el-scrollbar>
          </el-aside>
          <el-main>
            <el-scrollbar :style="contentHeight" >
              <router-view />
            </el-scrollbar>
          </el-main>
        </el-container>
    </el-container>
  </div>
</template>

<script>
import Nav from '@/components/layout/nav'

export default {
  name: "App",
  components:{
    Nav
  },
  computed: {
    navHeight () {
      return {
        height: window.screen.height - 210 + 'px'
      }
    },
    contentHeight () {
      return {
        height: window.screen.height - 210 + 'px'
      }
    }
  },
};
</script>

<style scoped>


</style>
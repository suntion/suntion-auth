<template>
  <div>
    <el-container direction="vertical" style="height:100%">
      <el-container>
        <el-aside>
          <v-nav/>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import nav from "@/components/layout/nav";
import header from "@/components/layout/header";
export default {
  data() {
    return {
      user: {},
      num: 300
    };
  },
  components: {
    "v-nav": nav,
    "v-header": header
  },
  beforeCreate: function () {
    this.$router.push("index");
  }
};
</script>

<style>
body {
  margin: 0;
  overflow-x: hidden;
}
.el-aside {
  display: block;
  position: absolute;
  left: 0;
  bottom: 0;
  overflow-x: hidden;
}
.el-main {
  position: absolute;
  left: 300px;
  right: 0;
  top: 30px;
  bottom: 0;
  overflow-y: scroll;
  overflow-x: hidden;
}
</style>

<template>
<div>
   <el-container direction="vertical" style="height:100%">
        <v-header :user="user"/>
        <el-container style="padding-top:80px">
            <el-aside>
              <v-nav/>
            </el-aside>
            <el-main>
              <router-view />
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
      num:300
    };
  },
  components: {
    "v-nav": nav,
    "v-header": header
  },
  beforeCreate: function() {
    this.$router.push("index");
  },
  created() {
    this.user = {
      name: "@cname",
      area: "@province(true)",
      identity: "超级管理员"
    };
  }
};
</script>

<style>
body {
  background-color: #f2f2f2;
  margin: 0;
  overflow: hidden;
}

.el-scrollbar__wrap {
  overflow-x: hidden;
}
</style>
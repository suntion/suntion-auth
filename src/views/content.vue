<template>
  <div id="content">
    <h1>欢迎来到我的系统{{count}}</h1>
    <h1>欢迎来到我的系统{{countAlias}}</h1>
    <h1>欢迎来到我的系统{{myCmpted}}</h1>
    <hr/>
    <el-button @click="increment">+</el-button>
    <el-button @click="decrement">-</el-button>
  </div>
</template>

<script>
  import {mapState} from 'vuex'

  export default {
    name: 'index',
    data() {
      return {
        str: '国际'
      }
    },
    methods: {
      increment() {
        this.$store.commit('increment')
      },
      decrement() {
        this.$store.commit('decrement')
      }
    },
    computed: mapState({
      count: 'count',
      countAlias: (state) => state.count,
      myCmpted: function () {
        return '测试' + this.str
      }
    }),

  }
</script>


<style scoped>
  #index {
    background-color: yellow
  }
</style>


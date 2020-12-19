<template>
  <div>
    <el-scrollbar style="height:100%;overflow-x:hidden">
      <h1>document</h1>
      <vue-markdown>{{ msg }}</vue-markdown>
    </el-scrollbar>
  </div>
</template>

<script>
import VueMarkdown from 'vue-markdown';
import README from '@/markdown/test.md';

export default {
  name: 'document',
  components: {
    VueMarkdown
  },
  data() {
    return {
      msg: README
    }
  },
  methods: {}
}
</script>

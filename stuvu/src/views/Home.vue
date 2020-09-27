<template>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider v-model="collapsed" collapsible>
      <div class="logo" />
      <a-menu theme="dark" :default-selected-keys="['3']" mode="inline">
        <a-menu-item key="1">
          <router-link to="about">
            <a-icon type="pie-chart" />
            <span>表单</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="2">

          <router-link to="list">
          <a-icon type="desktop" />
            <span>用户列表</span>
          </router-link>
        </a-menu-item>
        <a-sub-menu key="sub1">
          <span slot="title">
            <a-icon type="user" />
            <span>User</span>
          </span>
          <a-menu-item key="3">Tom</a-menu-item>
          <a-menu-item key="4">Bill</a-menu-item>
          <a-menu-item key="5">Alex</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <span slot="title">
            <a-icon type="team" />
            <span>Team</span>
          </span>
          <a-menu-item key="6">Team 1</a-menu-item>
          <a-menu-item key="8">Team 2</a-menu-item>
        </a-sub-menu>
        <a-menu-item key="9">
          <router-link  to="job">
          <a-icon type="file" />
          <span>定时任务</span>
          </router-link>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0" />
      <a-layout-content style="margin: 0 16px">
        <router-view></router-view>
      </a-layout-content>
      <a-layout-footer style="text-align: center">Ant Design ©2018 Created by Ant UED</a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script>
export default {
  name: "Home",
  data() {
    return {
      collapsed: false,
    };
  },
};
</script>

<style>
#components-layout-demo-side .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}
</style>

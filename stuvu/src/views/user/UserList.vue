<template>
  <div id="components-form-demo-advanced-search">
    <a-input-search
      placeholder="input search text"
      enter-button="Search"
      size="default"
      v-model="city"
      id="searchSize_user"
      @search="onSearch"
    />
       <a-button type="primary" @click="showModal">
      Open Modal with async logic
    </a-button>
    <a-table :columns="columns" :data-source="data" bordered rouKey='userId'>
      <template slot="username" slot-scope="text">
        <a>{{ text }}</a>
      </template>
    </a-table>
  </div>
</template>
<script>
const columns = [
  {
    title: "姓名",
    dataIndex: "username",
    scopedSlots: { customRender: "name" },
  },
  {
    title: "用户id",
    className: "column-money",
    dataIndex: "userId",
  },
  {
    title: "电话",
    dataIndex: "phone",
  },
];

import UserApi from "@/api/user.js";
export default {
  data() {
    return {
      data: [],
      columns,
      city: "",
    };
  },
  methods: {
      showModal() {
      this.visible = true;
    },
     handleOk(e) {
      this.ModalText = 'The modal will be closed after two seconds';
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
      }, 2000);
    },
    handleCancel(e) {
      console.log('Clicked cancel button');
      this.visible = false;
    },
    
    getUserList() {
      let _this = this;

      console.info(_this, "this");
      UserApi.userList(null).then((res) => {
        console.log(res.data);
        this.data = res.data;
      });
    },
    onSearch() {
      console.log(this.city);
    },
  },
  mounted() {
    this.getUserList();
  },
};
</script>
<style>
#searchSize_user {
  width: 200px;
 }
th.column-money,
td.column-money {
  text-align: right !important;
}

.ant-advanced-search-form {
  padding: 24px;
  background: #fbfbfb;
  border: 1px solid #d9d9d9;
  border-radius: 6px;
}

.ant-advanced-search-form .ant-form-item {
  display: flex;
}

.ant-advanced-search-form .ant-form-item-control-wrapper {
  flex: 1;
}

#components-form-demo-advanced-search .ant-form {
  max-width: none;
}
#components-form-demo-advanced-search .search-result-list {
  margin-top: 16px;
  border: 1px dashed #e9e9e9;
  border-radius: 6px;
  background-color: #fafafa;
  min-height: 200px;
  text-align: center;
  padding-top: 80px;
}
</style>

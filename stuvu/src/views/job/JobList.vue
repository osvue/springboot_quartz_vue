<template>
  <div>
    <a-row>
      <a-col :span="1">
        <a-button type="primary" @click="handleAdd()">Add</a-button>
      </a-col>
    </a-row>

    <!-- table区域-begin -->
    <a-table bordered
      :columns="columns"
      :data-source="data"
      :pagination="pagination"
      :loading="loading"
      rowKey="description"
    >
      <template #triggerState="text">
        <div>
          <a-tag  color="orange"  v-show="text == 'PAUSED'">暂停</a-tag>
          <a-tag  color="green"  v-show="text == 'ACQUIRED'">正常执行</a-tag>
          <a-tag  color="pink"  v-show="text == 'WAITING'">等待</a-tag>
          <a-tag  color="red"  v-show="text == 'ERROR'">错误</a-tag>
          <a-tag  color="purple"  v-show="text == 'BLOCKED'">阻塞</a-tag>
        </div>
      </template>

      <template #oldJobName="text,record">
        <span>
          <a-popconfirm
            title="Are you sure trigger this task?"
            ok-text="Yes"
            cancel-text="No"
            @confirm="handletrigger(record)"
          >
            <a href="#">触发</a>
          </a-popconfirm>

          <a-divider type="vertical" />
          <a href="#" @click="showModal(record)">修改</a>
          <a-divider type="vertical" />
          <a class="ant-dropdown-link">移除</a>
          <a-divider type="vertical" />
          <a class="ant-dropdown-link">
            <span v-show="record.triggerState == 'PAUSED'" @click="resetJob(record)">恢复</span>
            <span v-show="record.triggerState != 'PAUSED'" @click="stopJob(record)">暂停</span>
          </a>
        </span>
      </template>
    </a-table>

    <a-modal
      :title="dialog_title"
      :visible="visible"
      :confirm-loading="confirmLoading"
      @ok="handleOk"
      @cancel="handleCancel"
    >
      <a-form-model
        ref="ruleForm"
        :model="form"
        :rules="rules"
        :label-col="{ span: 6 }"
        :wrapper-col="{ span: 15 }"
      >
        <a-form-model-item ref="name" label="任务名称" prop="jobName">
          <a-input
            v-model="form.jobName"
            @blur="
          () => {
            $refs.name.onFieldBlur();
          }
        "
          />
        </a-form-model-item>
<input type="hidden" name="commnet" id='commnet'>
        <a-form-model-item label="任务分组">
          <a-input v-model="form.jobGroup" />
        </a-form-model-item>
        <a-form-model-item label="任务描述">
          <a-input v-model="form.description" />
        </a-form-model-item>
        <a-form-model-item label="执行类">
          <a-input v-model="form.jobClassName" type="textarea" />
        </a-form-model-item>
        <a-form-model-item label="执行方法">
          <a-input v-model="form.jobMethodName" />
        </a-form-model-item>
        <a-form-model-item label="执行时间">
          <a-input v-model="form.cronExpression" />
        </a-form-model-item>
      </a-form-model>
    </a-modal>
  </div>
</template>
<script>
import JobApi from "@/api/job.js";
const columns = [
  {
    title: "#",
    dataIndex: "",
    key: "rowIndex",
    width: 60,
    align: "center",
    customRender: function (t, r, index) {
      return parseInt(index) + 1;
    },
  },
  {
    title: "任务名称",
    align: "center",
    dataIndex: "jobName",
  },
  {
    title: "描述",
    align: "center",
    dataIndex: "description",
  },
  {
    title: "任务状态",
    align: "center",
    dataIndex: "triggerState",
     scopedSlots: { customRender: "triggerState" },
    /* ,
    customRender: (text) => {
      let re = "";
      if (text === "PAUSED") {
        re = "暂停";
      } else if (text === "ACQUIRED") {
        re = "活动";
      } else if (text === "ACQUIRED") {
        re = "等待";
      } else if (text === "ACQUIRED") {
        re = "阻塞";
      }
      return re;
    }, */
  },
  {
    title: "工作类",
    align: "center",
    dataIndex: "jobClassName",
  },
  {
    title: "corn表达式",
    align: "center",
    dataIndex: "cronExpression",
  },
  {
    title: "任务组",
    align: "center",
    dataIndex: "jobGroup",
  },
  {
    title: "调用实例",
    align: "center",
    dataIndex: "jobMethodName",
  },
  {
    title: "操作",
    dataIndex: "oldJobName",
    align: "center",
    scopedSlots: { customRender: "oldJobName" },
  },
];
let data = [];
export default {
  components: {},
  name: "JobList",
  data() {
    return {
      dialog_title: "",
      visible: false,
      confirmLoading: false,
      text: "触发任务吗？",
      pagination: {
        pageSize: 10, // 默认每页显示数量
        showSizeChanger: true, // 显示可改变每页数量
        pageSizeOptions: ["10", "20", "30", "40"], // 每页数量选项
        showTotal: (total) => `Total ${total} items`, // 显示总数
        showSizeChange: (current, pageSize) => (this.pageSize = pageSize), // 改变每页数量时更新显示
      },
      // 请求参数
      url: {
        list: "/test/jeecgOrderMain/list",
        delete: "/test/jeecgOrderMain/delete",
      },
      // 表头
      columns,
      data,
      loading: false,

      // modal dialog
      form: {
        jobName: "",
        jobGroup: "",
        description: "",
        jobClassName: "",
        jobMethodName: "",
        cronExpression: "",
        //旧任务名称  用于修改
        oldJobName: "",
        oldJobGroup: "",
      },
      rules: {
        jobName: [
          {
            required: true,
            message: "Please input jobName",
            trigger: "blur",
          },
        ],
      },
    };
  },
  mounted() {
    this.fetch();
  },
  methods: {
    resetJob(job) {
      JobApi.resumeJob(job).then((res) => {
        if (res.code == 200) {
          this.$message.success("启动任务成功！！");
          this.fetch();
        } else {
          this.$message.error("启动任务失败！！" + res.data);
        }
      });
    },
    stopJob(job) {
      JobApi.stopJob(job).then((res) => {
        if (res.code == 200) {
          this.$message.success("暂停任务成功！！");
          this.fetch();
        } else {
          this.$message.error("暂停任务失败！！" + res.data);
        }
      });
    },
    onSubmit() {
      console.log("submit!", this.form);
    },
    handleOk(e) {
      this.confirmLoading = true;
      console.log(this.form);
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          // 决定是新增还是修改
          JobApi.updateOrAdd(this.form).then((res) => {
            console.log(res);
            if (res.code == 200) {
              this.$message.success("SUCCESS !!");
              this.visible = false;
              this.confirmLoading = false;
              this.fetch();
            }
          });
        } else {
          this.$message.error("error submit!!");
          return false;
        }
      });
    },
    handleCancel(e) {
      console.log("Clicked cancel button");
      this.visible = false;
    },
    showModal(job) {
      this.dialog_title = "编辑任务";
      this.form = { ...job };
      this.visible = true;
    },
    confirm() {
      message.info("Clicked on Yes.");
    },
    handletrigger(job) {
      // 触发
      JobApi.trigger(job).then((res) => {
        if (res.code == 200) {
          this.$message.success("成功触发一次任务！！");
        }
      });
    },
    handleStop(args) {
      console.log("args", args);
    },
    handleAdd() {
      this.form = {};
      this.dialog_title = "新增任务";
      this.visible = true;
    },
    handleTableChange() {
      // 排序分页表格
    },
    fetch(params = {}) {
      console.log("params:", params);
      this.loading = true;
      JobApi.jobList(params).then((data) => {
        console.log("data", data.data);
        let result = data.data;

        const total = { ...result };
        // Read total count from server
        // pagination.total = data.totalCount;
        // pagination.total = 200;
        this.loading = false;
        this.data = result.list;
        this.pagination.showTotal(total);
      });
    },
  },
};
</script>
<style>
.editable-add-btn {
  margin-bottom: 8px;
  float: left;
}
</style>

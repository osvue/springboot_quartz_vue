<template>
  <div class="about">
    <a-form-model
      ref="ruleForm"
      :model="form"
      :rules="rules"
      :label-col="labelCol"
      :wrapper-col="wrapperCol"
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

      <a-form-model-item label="任务分组">
        <a-input v-model="form.jobGroup" />
      </a-form-model-item>
      <a-form-model-item label="任务描述">
        <a-input v-model="form.description" />
      </a-form-model-item>
      <a-form-model-item label="执行类">
        <a-input v-model="form.jobClassName" />
      </a-form-model-item>
      <a-form-model-item label="执行方法">
        <a-input v-model="form.jobMethodName" />
      </a-form-model-item>
      <a-form-model-item label="执行时间">
        <a-input v-model="form.cronExpression" />
      </a-form-model-item>

      <a-form-model-item :wrapper-col="{ span: 3, offset: 3 }">
        <a-button type="primary" @click="onSubmit">Create</a-button>
        <a-button style="margin-left: 10px;">Cancel</a-button>
      </a-form-model-item>
    </a-form-model>

    <input type="text" v-model="form.name" />
  </div>
</template>

<script>
export default {
  name: "About",
  data() {
    return {
      form: {
        jobName: "",
        jobGroup: "",
        description: "",
        jobClassName: "com.itstyle.quartz.job.ChickenJob",
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
          {
            min: 3,
            max: 5,
            message: "Length should be 3 to 5",
            trigger: "blur",
          },
        ],
      },
      labelCol: { span: 3 },
      wrapperCol: { span: 5 },
    };
  },
  methods: {
    onSubmit() {
      console.log("submit!", this.form);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.about {
  margin-top: 20px;
}
</style>

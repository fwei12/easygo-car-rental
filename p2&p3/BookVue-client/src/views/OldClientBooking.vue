<template>



  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm">


    <el-form-item label="Email" prop="email" required>
      <el-input v-model="ruleForm.email"></el-input>
    </el-form-item>
    <el-form-item label="Password" prop="password" required>
      <el-input v-model="ruleForm.password"></el-input>
    </el-form-item>



    <el-form-item>
      <el-button type="primary" @click="submitForm()">Check my Id</el-button>



      <el-button @click="resetForm('ruleForm')">reset</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          email: '',
          password: '',
        },
        rules: {
          email: [
            { required: true, message: 'Please enter email', trigger: 'blur' },
          ],
          password: [
            { required: true, message: 'Please enter password', trigger: 'blur' }
          ],}
      };
    },
    methods: {
      submitForm() {
        const _this = this;

              axios.get('http://localhost:8181/client/findByEmailAndPassword/'+ _this.ruleForm.email +'/' + _this.ruleForm.password).then(function (resp) {

                if (resp.data == -1) {
                  _this.$message({
                    type: 'error',
                    message: 'Not found! Please make sure your information is right.'
                  });

                }else {
                  _this.$notify({
                    title: 'Your client id is ' + resp.data,
                    message: "Please don't Close! You will use it while filling the booking form.",
                    duration: 0
                  });

                  _this.$router.push("/addBooking")
                }

              });




      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      created() {


      }

    }
  }
</script>

<style>

</style>

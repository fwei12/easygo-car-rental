<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm">
<!--    <el-form-item label="Client ID" prop="id">-->
<!--      <el-input v-model="ruleForm.id" ></el-input>-->
<!--    </el-form-item>-->
    <el-form-item label="First Name" prop="firstName" required>
      <el-input v-model="ruleForm.firstName"></el-input>
    </el-form-item>
    <el-form-item label="Last Name" prop="lastName" required>
      <el-input v-model="ruleForm.lastName"></el-input>
    </el-form-item>
    <el-form-item label="User Name" prop="username" required>
      <el-input v-model="ruleForm.username"></el-input>
    </el-form-item>

    <el-form-item label="Password" prop="password" required>
      <el-input v-model="ruleForm.password"></el-input>
    </el-form-item>

    <el-form-item label="Email" prop="email" required>
      <el-input v-model="ruleForm.email"></el-input>
    </el-form-item>

    <el-form-item label="Date Of Birth" required>
      <el-col :span="11">
        <el-form-item prop="dateOfBirth">
          <el-date-picker type="date" placeholder="Pick a date" v-model="ruleForm.dateOfBirth" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>


    <el-form-item label="Driver License" prop="driverLicense" required>
      <el-input v-model="ruleForm.driverLicense"></el-input>
    </el-form-item>

<!--    <el-form-item label="Admin Id" prop="adminId">-->
<!--      <el-input v-model="ruleForm.adminId"></el-input>-->
<!--    </el-form-item>-->


    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">Sign Up</el-button>
      <el-button @click="resetForm('ruleForm')">reset</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          //id:'',
          firstName: '',
          lastName: '',
          username: '',
          email:'',
          password: '',
          dateOfBirth: '',
          driverLicense: '',
         // adminId: ''
        },
        rules: {


          firstName: [
            { required: true, message: 'Please enter first name', trigger: 'blur' }
          ],

          lastName: [
            { required: true, message: 'Please enter last name', trigger: 'blur' }
          ],

          username: [
            { required: true, message: 'Please enter user name', trigger: 'blur' },
          ],


          email: [
            { required: true, message: 'Please enter email', trigger: 'blur' },
          ],
          password: [
            { required: true, message: 'Please enter password', trigger: 'blur' }
          ],

          dateOfBirth: [
            { required: true, message: 'Please enter date of birth', trigger: 'blur' },
          ],
          driverLicense: [
            { required: true, message: 'Please enter driver license', trigger: 'blur' }
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('This will submit your information to our system. Continue?', 'Confirm', {
              confirmButtonText: 'OK',
              cancelButtonText: 'Cancel',
              type: 'warning',
              center: true
            }).then(() => {
              const _this = this
              axios.post('http://localhost:8181/client/save', this.ruleForm).then(function (resp) {
                axios.get('http://localhost:8181/client/findByEmail/'+ _this.ruleForm.email).then(function (resp) {
                  console.log(resp.data)
                  _this.$notify({
                    title: 'Your client id is ' +  resp.data,
                    message: "Please don't Close! You will use it while filling the booking form.",
                    duration: 0
                  });
                });
              });



              this.$message({
                type: 'success',
                message: 'Sign up successfully!'
              });

              _this.$router.push("/addBooking")

            }).catch(() => {
              this.$message({
                type: 'info',
                message: 'Submit canceled'
              });
            });
          } else {
            console.log('error submit!!');
            return false;
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

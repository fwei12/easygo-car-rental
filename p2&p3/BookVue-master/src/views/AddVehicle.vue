<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
    <el-form-item prop="vin" label="VIN">
      <el-input v-model="ruleForm.vin"></el-input>
    </el-form-item>
    <el-form-item  prop="brand" label="Brand">
      <el-input v-model="ruleForm.brand"></el-input>
    </el-form-item>

    <el-form-item   prop="price" label="Price">
      <el-input v-model="ruleForm.price"></el-input>
    </el-form-item>

    <el-form-item prop="numOfSeats" label="Number of Seats">
      <el-input v-model="ruleForm.numOfSeats"></el-input>
    </el-form-item>



    <el-form-item   prop="mileage" label="Mileage">
      <el-input v-model="ruleForm.mileage"></el-input>
    </el-form-item>



    <el-form-item prop="availability" label="Availability">
      <el-input v-model="ruleForm.availability"></el-input>
    </el-form-item>



    <el-form-item prop="address" label="Address">
      <el-input v-model="ruleForm.address"></el-input>
    </el-form-item>


    <el-form-item prop="info" label="Info">
      <el-input v-model="ruleForm.info"></el-input>
    </el-form-item>
    <el-form-item prop="adminId" label="Admin Id">
      <el-input v-model="ruleForm.adminId"></el-input>
    </el-form-item>




    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">Submit</el-button>
      <el-button @click="resetForm('ruleForm')">Reset</el-button>
    </el-form-item>
  </el-form>
  </template>
  <script>
    export default {
      data() {
        return {

          ruleForm: {
            vin: '',
            brand: '',
            price: '',
            numOfSeats: '',
            mileage: '',
            availability: '',
            address: '',
            info: '',
            adminId: '',
          },
          rules: {

          }
        };
      },
      methods: {
        submitForm(formName) {
          const _this = this;
          this.$refs[formName].validate((valid) => {
            if (valid) {
              this.$confirm('This will submit a vehicle to our system. Continue?', 'Confirm', {
                confirmButtonText: 'OK',
                cancelButtonText: 'Cancel',
                type: 'warning',
                center: true
              }).then(() => {
                axios.post('http://localhost:8181/vehicle/save', this.ruleForm).then(function (resp) {
                  if(resp.data === "success"){
                    _this.$message({
                      type: 'success',
                      message: 'Vehicle added!'
                    });

                    setTimeout(function () {
                      _this.$router.push('/');
                      window.location.reload()
                    },2000)

                  } else {
                    _this.$message({
                      type: 'error',
                      message: 'Add Fail! Please make sure your information is right.'
                    });
                  }
                })




              }).catch(() => {
                _this.$message({
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
        }
      }
    }
  </script>
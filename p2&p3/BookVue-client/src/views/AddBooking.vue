<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
    <el-form-item label="Pickup Locaton" prop="pickupLocation">
      <el-input v-model="ruleForm.pickupLocation"></el-input>
    </el-form-item>
    <el-form-item label="Return Locaton" prop="returnLocation">
      <el-input v-model="ruleForm.returnLocation"></el-input>
    </el-form-item>

    <el-form-item label="Booking Date" required>
      <el-col :span="11">
        <el-form-item prop="bookingDate">
          <el-date-picker readonly type="date" placeholder="Pick a date" v-model="ruleForm.bookingDate" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>

    <el-form-item label="Departure Date" required>
      <el-col :span="11">
        <el-form-item prop="departureDate">
          <el-date-picker type="date" placeholder="Pick a date" v-model="ruleForm.departureDate" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>

    <el-form-item label="Return Date" required>
      <el-col :span="11">
        <el-form-item prop="returnDate">
          <el-date-picker type="date" placeholder="Pick a date" v-model="ruleForm.returnDate" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>
    <el-form-item label="Client ID" prop="clientId">
      <el-input v-model="ruleForm.clientId"></el-input>
    </el-form-item>
    <el-form-item label="Vehicle ID" prop="vehicleId">
      <el-input v-model="ruleForm.vehicleId"></el-input>
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
            pickupLocation: '',
            returnLocation: '',
            bookingDate: new Date(),
            departureDate: '',
            returnDate: '',
            clientId: '',
            vehicleId: ''
          },
          rules: {
            pickupLocation: [
              { required: true, message: 'Please select pickup location', trigger: 'blur' },
            ],
            returnLocation: [
              { required: true, message: 'Please select return location', trigger: 'blur' }
            ],
            departureDate: [
              { type: 'date', required: true, message: 'Please pick a date', trigger: 'change' }
            ],
            returnDate: [
              { type: 'date', required: true, message: 'Please pick a date', trigger: 'change' }
            ],
            clientId: [
              { required: true, message: 'Please select client id', trigger: 'blur' }
            ],
            vehicleId: [
              { required: true, message: 'Please select vehicle id', trigger: 'blur' }
            ]

          }
        };
      },
      methods: {
        submitForm(formName) {
          const _this = this;
          this.$refs[formName].validate((valid) => {
            if (valid) {
              this.$confirm('This will submit a booking to our system. Continue?', 'Confirm', {
                confirmButtonText: 'OK',
                cancelButtonText: 'Cancel',
                type: 'warning',
                center: true
              }).then(() => {
                axios.post('http://localhost:8181/booking/save', this.ruleForm).then(function (resp) {
                  if(resp.data === "success"){
                    _this.$message({
                      type: 'success',
                      message: 'Booking Submit!'
                    });

                    setTimeout(function () {
                      _this.$router.push('/');
                      window.location.reload()
                    },2000)

                  } else {
                    _this.$message({
                      type: 'error',
                      message: 'Booking Fail! Please make sure your information is right.'
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
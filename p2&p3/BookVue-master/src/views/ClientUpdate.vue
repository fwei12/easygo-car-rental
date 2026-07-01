<template>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm">
        <el-form-item label="Client ID" prop="id">
            <el-input v-model="ruleForm.id" ></el-input>
        </el-form-item>
    <el-form-item label="First Name" prop="firstName">
        <el-input v-model="ruleForm.firstName"></el-input>
    </el-form-item>
    <el-form-item label="Last Name" prop="firstName">
        <el-input v-model="ruleForm.lastName"></el-input>
    </el-form-item>
        <el-form-item label="User Name" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="Password" prop="password">
            <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>

        <el-form-item label="Email" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
        </el-form-item>

    <el-form-item label="Date Of Birth">
        <el-col :span="11">
            <el-form-item prop="dateOfBirth">
                <el-date-picker type="date" placeholder="Pick a date" v-model="ruleForm.dateOfBirth" style="width: 100%;"></el-date-picker>
            </el-form-item>
        </el-col>
    </el-form-item>


        <el-form-item label="Driver License" prop="driverLicense">
            <el-input v-model="ruleForm.driverLicense"></el-input>
        </el-form-item>

        <el-form-item label="Admin Id" prop="adminId">
            <el-input v-model="ruleForm.adminId"></el-input>
        </el-form-item>


        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">update</el-button>
            <el-button @click="resetForm('ruleForm')">reset</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    id: '',
                    firstName: '',
                    lastName: '',
                    username: '',
                    password:'',
                    dateOfBirth:'',
                    driverLicense: '',
                    adminId:''
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
                        this.$confirm('This will update the client to our system. Continue?', 'Confirm', {
                            confirmButtonText: 'OK',
                            cancelButtonText: 'Cancel',
                            type: 'warning',
                            center: true
                        }).then(() => {
                            axios.post('http://localhost:8181/client/save', this.ruleForm).then(function (resp) {
                                if(resp.data === "success"){
                                    _this.$message({
                                        type: 'success',
                                        message: 'Updating Submit!'
                                    });

                                    setTimeout(function () {
                                        _this.$router.push('/');
                                        window.location.reload()
                                    },2000)

                                } else {
                                    _this.$message({
                                        type: 'error',
                                        message: 'Updating Fail! Please make sure your information is right.'
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
                const _this=this
                axios.get('http://localhost:8181/client/findById/'+this.$route.query.id).then(function (resp){
                    _this.ruleForm.id=resp.data.id;

                    _this.ruleForm.firstName=resp.data.firstName;

                    _this.ruleForm.lastName=resp.data.lastName;

                    _this.ruleForm.username=resp.data.username;
                    _this.ruleForm.password = resp.data.password;
                    _this.ruleForm.email = resp.data.email;
                    _this.ruleForm.dateOfBirth=new Date(resp.data.dateOfBirth);
                    _this.ruleForm.driverLicense = resp.data.driverLicense;
                    _this.ruleForm.adminId = resp.data.adminId;

                })
            }
        },
        created() {
            const _this=this
            axios.get('http://localhost:8181/client/findById/'+this.$route.query.id).then(function (resp){
                console.log(resp.data);
                _this.ruleForm.id=resp.data.id;

                _this.ruleForm.firstName=resp.data.firstName;

                _this.ruleForm.lastName=resp.data.lastName;

                _this.ruleForm.username=resp.data.username;
                _this.ruleForm.password = resp.data.password;
                _this.ruleForm.email = resp.data.email;
                _this.ruleForm.dateOfBirth=new Date(resp.data.dateOfBirth);
                _this.ruleForm.driverLicense = resp.data.driverLicense;
                _this.ruleForm.adminId = resp.data.adminId;

            })


        }

    }
</script>

<style>

</style>

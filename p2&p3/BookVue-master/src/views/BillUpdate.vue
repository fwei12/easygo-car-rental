<template>


    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
        <el-form-item prop="billNumber" label="Bill Number">
            <el-input v-model="ruleForm.billNumber"></el-input>
        </el-form-item>

        <el-form-item label="Bill Date">
            <el-col :span="11">
                <el-form-item prop="billDate">
                    <el-date-picker readonly type="date" placeholder="Pick a date" v-model="ruleForm.billDate" style="width: 100%;"></el-date-picker>
                </el-form-item>
            </el-col>
        </el-form-item>

        <el-form-item   prop="amountToPaid" label="Amount To Paid">
            <el-input v-model="ruleForm.amountToPaid"></el-input>
        </el-form-item>

        <el-form-item prop="bookingId" label="Booking Id">
            <el-input v-model="ruleForm.bookingId"></el-input>
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
                    id: '',
                    billNumber: '',
                    billDate: '',
                    amountToPaid: '',
                    bookingId: '',
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
                        this.$confirm('This will update the bill to our system. Continue?', 'Confirm', {
                            confirmButtonText: 'OK',
                            cancelButtonText: 'Cancel',
                            type: 'warning',
                            center: true
                        }).then(() => {
                            axios.post('http://localhost:8181/bill/save', this.ruleForm).then(function (resp) {
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
                axios.get('http://localhost:8181/bill/findById/'+this.$route.query.id).then(function (resp){
                    _this.ruleForm.id=resp.data.id;
                    _this.ruleForm.billNumber=resp.data.billNumber;
                    _this.ruleForm.billDate=new Date(resp.data.billDate);
                    _this.ruleForm.amountToPaid = resp.data.amountToPaid;
                    _this.ruleForm.bookingId = resp.data.bookingId;

                })
            }
        },
        created() {
            const _this=this
            axios.get('http://localhost:8181/bill/findById/'+this.$route.query.id).then(function (resp){
                console.log(resp.data);
                _this.ruleForm.id=resp.data.id;
                _this.ruleForm.billNumber=resp.data.billNumber;
                _this.ruleForm.billDate=new Date(resp.data.billDate);
                _this.ruleForm.amountToPaid = resp.data.amountToPaid;
                _this.ruleForm.bookingId = resp.data.bookingId;

            })


        }

    }
</script>

<style>

</style>

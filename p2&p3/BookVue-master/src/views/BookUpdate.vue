<template>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm">
        <el-form-item label="Booking ID" prop="id">
            <el-input v-model="ruleForm.id" ></el-input>
        </el-form-item>
    <el-form-item label="Pickup Locaton" prop="pickupLocation">
        <el-input v-model="ruleForm.pickupLocation"></el-input>
    </el-form-item>
    <el-form-item label="Return Locaton" prop="returnLocation">
        <el-input v-model="ruleForm.returnLocation"></el-input>
    </el-form-item>

    <el-form-item label="Re-Booking Date" required>
        <el-col :span="11">
            <el-form-item prop="bookingDate">
                <el-date-picker type="date" placeholder="Pick a date" v-model="ruleForm.bookingDate" style="width: 100%;"></el-date-picker>
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
                    pickupLocation: '',
                    returnLocation: '',
                    bookingDate: new Date(),
                    departureDate: '',
                    returnDate: '',
                    clientId: '',
                    vehicleId: ''
                },
                rules: {
                    id: [
                        { required: true, message: 'Please select id', trigger: 'blur' },
                    ],
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
                        this.$confirm('This will update a booking in our system. Continue?', 'Confirm', {
                            confirmButtonText: 'OK',
                            cancelButtonText: 'Cancel',
                            type: 'warning',
                            center: true
                        }).then(() => {
                            axios.post('http://localhost:8181/booking/save', this.ruleForm).then(function (resp) {
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
                                        message: 'Updating Fail! Please make sure your IDs are right.'
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
                axios.get('http://localhost:8181/booking/findById/'+this.$route.query.id).then(function (resp){
                    _this.ruleForm.id=resp.data.id;

                    _this.ruleForm.pickupLocation=resp.data.pickupLocation;

                    _this.ruleForm.returnLocation=resp.data.returnLocation;

                    _this.ruleForm.departureDate=new Date(resp.data.departureDate);
                    _this.ruleForm.returnDate=new Date(resp.data.returnDate);

                    _this.ruleForm.clientId=resp.data.clientId;

                    _this.ruleForm.vehicleId=resp.data.vehicleId;

                })
            }
        },
        created() {
            const _this=this
            axios.get('http://localhost:8181/booking/findById/'+this.$route.query.id).then(function (resp){
                console.log(resp.data);
                _this.ruleForm.id=resp.data.id;

                _this.ruleForm.pickupLocation=resp.data.pickupLocation;

                _this.ruleForm.returnLocation=resp.data.returnLocation;

                _this.ruleForm.departureDate=new Date(resp.data.departureDate);
                _this.ruleForm.returnDate=new Date(resp.data.returnDate);

                _this.ruleForm.clientId=resp.data.clientId;

                _this.ruleForm.vehicleId=resp.data.vehicleId;

            })


        }

    }
</script>

<style>

</style>

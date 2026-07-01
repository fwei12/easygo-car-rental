


<template>


    <div>



                <el-page-header @back="goBack" content="Bookings">
                </el-page-header>


                <!--    加个筛选表的窗口-->

                <el-table
                    :data="tableData"
                    border
                    style="width: 100%">
                    <el-table-column
                        fixed
                        prop="id"
                        label="Id"
                        width="70">
                    </el-table-column>
                    <el-table-column
                        prop="pickupLocation"
                        label="Pickup location"
                        width="120">
                    </el-table-column>
                    <el-table-column
                        prop="returnLocation"
                        label="Return Location"
                        width="122">
                    </el-table-column>
                    <el-table-column
                        prop="bookingDate"
                        label="Booking Date"
                        width="115">
                    </el-table-column>
                    <el-table-column
                        prop="departureDate"
                        label="Departure Date"
                        width="120">
                    </el-table-column>
                    <el-table-column
                        prop="returnDate"
                        label="Return Date"
                        width="120">
                    </el-table-column>
                    <el-table-column
                        prop="clientId"
                        label="Client Id"
                        width="100">
                    </el-table-column>
                    <el-table-column
                        prop="vehicleId"
                        label="Vehicle Id"
                        width="100">
                    </el-table-column>
                    <el-table-column
                        fixed="right"
                        label="Operations"
                        width="120">
                        <template #default="scope">
                            <el-button @click="edit(scope.row)" type="text" size="small">Update</el-button>
                            <el-button @click="deleteBooking(scope.row)" type="text" size="small">Delete</el-button>
                        </template>
                    </el-table-column>



                </el-table>


            </div>
        </template>

        <script>
            export default {
                methods: {

                    goBack(){
                        this.$router.push('/')
                    },
                    edit(row) {
                        this.$router.push({
                            path: '/update',
                            query: {
                                id: row.id
                            }
                        })
                    },
                    deleteBooking(row) {
                        const _this = this;
                        this.$confirm('This will permanently delete the booking. Continue', 'Warning', {
                            confirmButtonText: 'OK',
                            cancelButtonText: 'Cancel',
                            type: 'warning',
                            center: true
                        }).then(() => {
                            axios.delete('http://localhost:8181/booking/deleteById/' + row.id).then(
                                function (resp) {
                                });

                            this.$message({
                                type: 'success',
                                message: 'Delete Success!'
                            });

                            setTimeout(function () {
                                _this.$router.push('/');
                                window.location.reload()
                            },2000)


                        }).catch(() => {
                            this.$message({
                                type: 'info',
                                message: 'Delete canceled'
                            });
                        })
                    },


                },

                data() {
                    return {
                        tableData: null,
                    }
                },

                created() {
                    const _this = this
                    axios.get('http://localhost:8181/booking/findByClientId/' + _this.$route.query.id).then(function (resp) {
                        _this.tableData = resp.data
                        console.log(resp.data)
                    })
                }
            }

        </script>

        <style>

        </style>

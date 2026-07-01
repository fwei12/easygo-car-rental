


<template>


    <div>



                <el-page-header @back="goBack" content="Client">
                </el-page-header>



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
                        prop="firstName"
                        label="First Name"
                        width="100">
                    </el-table-column>
                    <el-table-column
                        prop="lastName"
                        label="Last Name"
                        width="100">
                    </el-table-column>
                    <el-table-column
                        prop="username"
                        label="User Name"
                        width="105">
                    </el-table-column>
                    <el-table-column
                        prop="password"
                        label="Password"
                        width="120">
                    </el-table-column>
                    <el-table-column
                        prop="email"
                        label="Email"
                        width="150">
                    </el-table-column>
                    <el-table-column
                        prop="dateOfBirth"
                        label="Date Of Birth"
                        width="110">
                    </el-table-column>
                    <el-table-column
                        prop="driverLicense"
                        label="Driver License"
                        width="110">
                    </el-table-column>
                    <el-table-column
                        prop="adminId"
                        label="AdminId"
                        width="110">
                    </el-table-column>
                    <el-table-column
                        fixed="right"
                        label="Operations"
                        width="120">
                        <template #default="scope">
                            <el-button @click="edit(scope.row)" type="text" size="small">Update</el-button>
                            <el-button @click="deleteClient(scope.row)" type="text" size="small">Delete</el-button>
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
                            path:'/ClientUpdate',
                            query:{
                                id:row.id
                            }
                        })
                    },
                    deleteClient(row) {
                        const _this = this;
                        this.$confirm('This will permanently delete the client. Continue', 'Warning', {
                            confirmButtonText: 'OK',
                            cancelButtonText: 'Cancel',
                            type: 'warning',
                            center: true
                        }).then(() => {
                            axios.delete('http://localhost:8181/client/deleteById/' + row.id).then(
                                function (resp) {
                                    console.log(resp.data)
                                });
                            this.$message({
                                type: 'success',
                                message: 'Delete Success!'
                            });


                            setTimeout(function () {
                                _this.$router.push('/ClientManage');
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
                    axios.get('http://localhost:8181/client/findById/' + _this.$route.query.id).then(function (resp) {
                        _this.tableData = new Array(resp.data)
                        console.log( _this.tableData)
                        console.log(resp.data)
                    })
                }
            }
        </script>

        <style>

        </style>


<style>

</style>

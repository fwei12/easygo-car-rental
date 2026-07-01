
<template>


<div>

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
                prop="vin"
                label="VIN"
                width="120">
        </el-table-column>
        <el-table-column
                prop="brand"
                label="Brand"
                width="122">
        </el-table-column>
        <el-table-column
                prop="price"
                label="Price"
                width="115">
        </el-table-column>
        <el-table-column
                prop="numOfSeats"
                label="Number of Seats"
                width="120">
        </el-table-column>
        <el-table-column
                prop="mileage"
                label="Mileage"
                width="120">
        </el-table-column>
        <el-table-column
            prop="availability"
            label="Availability"
            width="100">
        </el-table-column>
        <el-table-column
            prop="address"
            label="Address"
            width="100">
        </el-table-column>

        <el-table-column
            prop="info"
            label="Info"
            width="100">
        </el-table-column>

        <el-table-column
            prop="adminId"
            label="Admin Id"
            width="100">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="Operations"
                width="120">
            <template #default="scope">
                <el-button @click="edit(scope.row)" type="text" size="small">Update</el-button>
                <el-button @click="deleteCar(scope.row)" type="text" size="small">Delete</el-button>
            </template>
        </el-table-column>


        <el-table-column
            fixed="right"
            label="Check Bookings"
            width="120">
            <template #default="scope">
                <el-button @click="editBooking(scope.row)" type="text" size="small">Bookings</el-button>
            </template>
        </el-table-column>


    </el-table>


</div>
</template>

<script>
    export default {
        methods: {
            edit(row) {
                this.$router.push({
                    path:'/VehicleUpdate',
                    query:{
                            id:row.id
                    }
                })
            },
            editBooking(row){
                this.$router.push({
                    path:'/BookingManageByCarId',
                    query:{
                        id:row.id
                    }
                })
            },
            deleteCar(row) {
                const _this = this;
                this.$confirm('This will permanently delete the car. Continue', 'Warning', {
                    confirmButtonText: 'OK',
                    cancelButtonText: 'Cancel',
                    type: 'warning',
                    center: true
                }).then(() => {
                    axios.delete('http://localhost:8181/vehicle/deleteById/' + row.id).then(
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
            axios.get('http://localhost:8181/vehicle/findAll/').then(function (resp) {
                _this.tableData = resp.data
            })
        }
    }
</script>

<style>

</style>

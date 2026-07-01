
<template>


  <div>
    <el-page-header @back="goBack" content="Bill">
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
          prop="billNumber"
          label="Bill Number"
          width="120">
      </el-table-column>
      <el-table-column
          prop="billDate"
          label="Bill Date"
          width="122">
      </el-table-column>
      <el-table-column
          prop="amountToPaid"
          label="Amount To Pay"
          width="115">
      </el-table-column>
      <el-table-column
          prop="bookingId"
          label="Booking Id"
          width="120">
      </el-table-column>

      <el-table-column
          fixed="right"
          label="Operations"
          width="120">
        <template #default="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">Update</el-button>
          <el-button @click="deleteBill(scope.row)" type="text" size="small">Delete</el-button>
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
          path:'/BillUpdate',
          query:{
            id:row.id
          }
        })
      },

      deleteBill(row) {
        const _this = this;
        this.$confirm('This will permanently delete the booking. Continue', 'Warning', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning',
          center: true
        }).then(() => {
          axios.delete('http://localhost:8181/bill/deleteById/' + row.id).then(
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
      axios.get('http://localhost:8181/bill/findFirstByBookingId/' + _this.$route.query.id).then(function (resp) {
        _this.tableData = new Array(resp.data)
        console.log(resp.data)
      })
    }
  }
</script>

<style>

</style>

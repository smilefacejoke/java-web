<template>
   <div>

       <el-card class="box-card" >
           <el-form :inline="true" :model="searchForm" class="demo-form-inline" >
               <el-form-item label="查询">
                   <el-input v-model="searchForm.name" placeholder="学生姓名"></el-input>
               </el-form-item>
               <el-form-item>
                   <el-input v-model="searchForm.addr" placeholder="居住地址"></el-input>
               </el-form-item>
               <el-form-item label="班级">
                   <el-select v-model="searchForm.cid" placeholder="所在班级">
                       <el-option label="所有班级" value="0"></el-option>
                       <el-option :label="c.cname" :value="c.cid" v-for="c in classes"></el-option>
                   </el-select>
               </el-form-item>
               <el-form-item>
                   <el-button type="primary" @click="search()" icon="el-icon-search">查询</el-button>
                   <el-button type="success" @click="add()" icon="el-icon-plus">添加</el-button>
                   <el-button type="danger" @click="handleDelete()" icon="el-icon-minus">批量删除</el-button>
               </el-form-item>
           </el-form>
           <el-table
                   :data="students"
                   @selection-change="handleSelectionChange"
                   style="width: 100%">
               <el-table-column
                       type="selection"
                       width="55"
               >
               </el-table-column>
               <el-table-column
                       label="学号"
                       align="center"
                       prop="sid"
                       width="180">
               </el-table-column>
               <el-table-column
                       prop="name"
                       label="姓名"
                       align="center"
                       width="180">
               </el-table-column>
               <el-table-column
                       prop="age"
                       label="年龄"
                       align="center"
                       width="180">
               </el-table-column>
               <el-table-column
                       prop="addr"
                       label="住址"
                       align="center"
                       width="180">
               </el-table-column>
               <el-table-column
                       prop="cname"
                       align="center"
                       label="所在班级"
                       width="180">
               </el-table-column>
               <el-table-column label="操作" align="center">
                   <template slot-scope="scope">
                       <el-button
                               type="success"
                               plain
                               size="mini"
                               @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                       <el-button
                               size="mini"
                               type="danger"
                               plain
                               @click="handleDelete( scope.row.sid)">删除</el-button>
                   </template>
               </el-table-column>
           </el-table>

           <el-pagination
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   :current-page="page"
                   :page-sizes="[3, 4, 5, 6]"
                   :page-size="pageSize"
                   layout="total, sizes, prev, pager, next, jumper"
                   :total="total">
           </el-pagination>




           <el-dialog :title="title" :visible.sync="dialogFormVisible" align="left" :close-on-click-modal="false">
               <el-form :model="studForm" :rules="rules" ref="ruleForm">
                   <el-form-item label="学生姓名" :label-width="formLabelWidth" prop="name">
                       <el-input v-model="studForm.name" autocomplete="off"></el-input>
                   </el-form-item>
                   <el-form-item label="学生性别" :label-width="formLabelWidth" prop="sex">
                           <el-radio label="男" v-model="studForm.sex"></el-radio>
                           <el-radio label="女" v-model="studForm.sex"></el-radio>
                   </el-form-item>
                   <el-form-item label="学生年龄" :label-width="formLabelWidth" prop="age">
                       <el-input v-model.number="studForm.age" autocomplete="off"></el-input>
                   </el-form-item>
                   <el-form-item label="学生住址" :label-width="formLabelWidth" prop="addr">
                       <el-input v-model="studForm.addr" autocomplete="off"></el-input>
                   </el-form-item>
                   <el-form-item label="学生班级" :label-width="formLabelWidth" prop="cid">
                       <el-select v-model="studForm.cid" placeholder="请选择班级" style="width: 100%">
                           <el-option :label="c.cname" :value="c.cid" v-for="c in classes"></el-option>
                       </el-select>
                   </el-form-item>
               </el-form>
               <div slot="footer" class="dialog-footer">
                   <el-button @click="dialogFormVisible = false">取 消</el-button>
                   <el-button type="primary" @click="save()">确 定</el-button>
               </div>
           </el-dialog>
       </el-card>

   </div>
</template>

<script>
    export default {
        name: "Student",
        data(){
            const chackAge=(rule,value,callback)=>{
                if(!value){
                    return callback(new Error('年龄不能为空'));
                }else if(isNaN(value)){
                    return callback(new Error("年龄必须是数字"));
                }else {
                    return callback();
                }
            }
            return {
                multipleSelection:[],   //多选框得到的数组数据
                students: [],   //代表每页学生数
                classes: [],    //所有班级
                pageSize:5,     //代表每页大小
                page:1,         //地表当前页
                total:20,      //代表总页数
                searchForm:{},  //被搜索的学生变量
                title:"添加学生",//设置对话框标题
                dialogFormVisible:false,
                formLabelWidth:'120px', //对话框的宽度
                studForm:{},    //代表要添加或者要修改的学生对象数据
                rules:{
                    name:[{required:true,message:"请输入学生姓名", tirgger:'blur'}],

                    sex:[{required:true,message:"请输入性别", tirgger:'change'}],

                    // validator：使用自定义校验规则
                    age:[{validator:chackAge,trigger:'blur'}],

                    addr:[{required:true,message:"请输入学生住址",trigger:'blur'}],

                    cid:[{required:true,message:"请选择班级",trigger:'blur'}],


                },
            }
        },
        created() {
            //1. 查询所有学生
            // this.findAllStudents();
            //2. 分页查询
            // this.findPage(this.page,this.pageSize);
            // 3. 查询所有班级
            this.findAllClasses();
            //4. 分页带条件查询
            this.search();
        },
        methods:{
            //0.查询所有数据
            findAllStudents(){
                this.axios.get(`/student?cmd=list`).then(data=>{
                    console.log("data:",data);
                    // 1.1为总记录数赋值
                    this.students=data.data;
                })
            },
            //1. 查询所有学生
            findPage(page,pageSize){
                this.axios.get(`/student?cmd=findPage&page=${page}&pageSize=${pageSize}`).then(data=>{
                    console.log("data:",data);
                    // 1.1为总记录数赋值
                    this.total=data.data.total;
                    // 1.2为当前页的记录集合赋值
                    this.students=data.data.rows;


                })
            },
            //2. 每页大小（pagesize）改变时触发
            handleSizeChange(pageSize){
                console.log(`每页${pageSize}条`);
                this.pageSize=pageSize;
                this.search(this.page,this.pageSize);
            },
            //3. 每页page改变时触发
            handleCurrentChange(page){
                console.log(`当前页:${page}`);
                this.page=page;
                this.search(this.page,this.pageSize);
            },

            //4. 查询所有班级
            findAllClasses(){
                this.axios.get("/classes").then(data=>{
                    this.classes = data.data;
                })
            },

            //5. 条件查询带分页
            search(){
                this.axios.post(`/student?cmd=search&page=${this.page}&pageSize=${this.pageSize}`,
                    "stud="+JSON.stringify(this.searchForm)).then(data=>{
                    // 1.1 为总记录数赋值
                    this.total=data.data.total;
                    // 1.2 为当前页的记录集合赋值
                    this.students=data.data.rows;

                })
            },
            //6. 添加学生（界面）
            add(){
                // 6.1 修改对话框标题
                this.title="添加学生";
                // 6.2打开对话框
                this.dialogFormVisible=true;
                // 6.3 清空表单数据
                this.studForm={};



            },
            //7. 编辑学生
            handleEdit(index,row){
                // 7.1 修改标题
               this.title="修改学生";
               // 7.2 打开对话框
                this.dialogFormVisible=true;
                // 7.3 将当前修改的数据赋值给studForm
                this.studForm=row;



            },
            //8. 删除学生
            handleDelete(sid){
                let _this=this;
                //定义要删除的id数组
                let ids=[];
                // 8.1 处理一次性多个删除
                // if(sid){
                //     ids.push(sid);
                // }else {
                //     ids=this.multipleSelection.map(m=>{
                //         return m.sid;
                //     });
                // }
                //上面的代码可以改写为
                ids=sid?[sid]:this.multipleSelection.map(m=>m.sid);
                //删除提示
                this.$confirm(`是否真的要删除学号为${ids}的学生？`,`提示`,{
                    confirmButtonText:'确定',
                    cancelButtonText:'取消',
                    type:"warning"
                }).then(()=>{               //代表点击确定按钮
                    // 8.2 将id提交到后台进行删除
                    this.axios.get(`/student?cmd=deleteByIds&ids=${ids}`).then(data=>{
                        if (data.data.code===0){
                            this.$message({
                                type:'success',
                                message:'删除成功！',
                                onClose(){
                                    _this.search();
                                }
                            })
                        }
                    });

                }).catch(()=>{              //代表点击取消按钮的回调
                    this.$message({
                        type:'info',
                        message:'已取消删除'
                    });
                })

            },

            //9. 保存学生（添加或修改)
            save(){
                // 9.1 根据this.studForm.sid的值决定是添加还是修改,为url赋值
                let url="student?cmd=add";
                if(this.studForm.sid){
                    url="student?cmd=update";
                }
                // 9.2 表单验证提供后，就提交数据到后台
                this.$refs['ruleForm'].validate(valid=>{
                    let _this=this;
                    if(valid){
                        //valid=true，代表表单中所有的控件都验证通过了
                        this.axios.post(url,"stud="+JSON.stringify(this.studForm)).then(data=>{
                            if(data.data.code === 0){
                                //1. 关闭对话框
                                this.dialogFormVisible=false;
                                // 2. 弹出消息框
                                this.$message({
                                    message:`学生信息${this.studForm.sid ? '修改' : '添加'}成功`,
                                    type:'success',
                                    onClose(){
                                        //当消息框关闭时
                                        _this.search();
                                    }
                                })
                            }
                        })
                    }
                })


            },

            handleSelectionChange(val){
                this.multipleSelection=val;
            }
        },

    }
</script>

<style scoped>

    .el-pagination{
        margin-top: 20px;
        text-align: right;
    }
    .el-from{
       text-align: left;
    }

</style>
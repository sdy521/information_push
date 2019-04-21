function toastrInfo() {
    toastr.warning("暂未开发");
}

function FormatDate(dateTime) {
    var date = new Date(dateTime);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;//月份是从0开始的
    var day = date.getDate();
    var hour = date.getHours();
    var min = date.getMinutes();
    var sec = date.getSeconds();
    return year+'/'+month+'/'+day;
}
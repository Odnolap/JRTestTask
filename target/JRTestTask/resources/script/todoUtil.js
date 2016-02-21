function _TodoUtil(){

    this.deleteTodo = function(id){
        if (confirm("Are you sure?")){
            window.location = "/deleteTodo/" + id;
        }
    }

    this.completeTodo = function(id){
        if (confirm("Complete this TODO?")){
            window.location = "/completeTodo/" + id;
        }
    }

}

var TodoUtil = new _TodoUtil();
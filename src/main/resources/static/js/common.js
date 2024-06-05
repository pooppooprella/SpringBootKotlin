const _commonLib = (function () {
    return {
        callAjax: function (param) {
            const data = param.data || {};

            // 페이징 정보가 있을 경우 페이징 정보 추가
            if (typeof (param.paging) != "undefined" && param.paging == "Y") {
                data["paging"] = "Y";
                data["pageNumber"] = 1;

                if (typeof (param.pageNumber) != "undefined" && param.pageNumber != "") {
                    data.pageNumber = param.pageNumber;
                }
            }

            $.ajax({
                "url": param.url,
                "async": typeof (param.async) != "undefined" ? param.async : true,
                "type": param.type || "post",
                "data": param.data || {},
                "dataType": param.dataType,
                "complete": function () {

                },

                "success" : function(data){
                    if (typeof(param.callback) == "function") {
                        param.callback(data);
                    }
                },

                "error": function (xhr, status, error) {
                    if (xhr.status === "403") {
                        alert("세션이 만료되었습니다.");
                    } else {
                        alert("처리 중 오류가 발생했습니다.");
                    }
                }
            });
        },

        isEmpty: function (obj) {
            return (typeof obj != "undefined" && obj != null && obj != "null" && obj != "") ? false : true;
        },

        getValue: function (obj) {
            return typeof (obj) == "undefined" ? "" : obj == null ? "" : obj == "null" ? "" : obj;
        },

        setPagination: function (targetId, fnOnSelect, totalPage, pageNumber) {
            $("#" + targetId).twbsPagination("destroy");
            $("#" + targetId).twbsPagination({
                "totalPages": Number(totalPage),
                "startPage": Number(pageNumber),
                "visiblePages": 10,
                "first": "<<",
                "prev": "<",
                "next": ">",
                "last": ">>",
                "nextClass"  : "pagination-next pagination-font",
                "prevClass"  : "pagination-previous pagination-font",
                "lastClass"  : "pagination-last pagination-font",
                "firstClass" : "pagination-first pagination-font",
                "pageClass"  : "pagination-link ",
                "anchorClass": "pagination-link",
                "activeClass": "pagination-link is-current",
                "initiateStartPageClick": false,
                "onPageClick": function (event, page) {
                    fnOnSelect(page);
                }
            });
        },
    }
})


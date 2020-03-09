<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css" crossorigin="anonymous">
  <script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
  <script src="./bootstrap/js/bootstrap.min.js" crossorigin="anonymous"></script>

  <Script type="text/javascript">
      $(function () {
          // 页面加载完成后，获取初始信息
          getProducts(1, 5);
      });

      /**
       * 获取页面信息
       * @param page  当前页码
       * @param pageSize  每页数量
       */
      function getProducts(page, pageSize) {
          var url = "/jQueryPagination/ProductServlet?page=" + page + "&pageSize=" + pageSize;
          $.get(url, function (data) { // ajax异步请求数据
              // 清空table数据
              $("#table tr:not(:first)").remove();

              // jsonString to jsObject
              var pageBean = eval(data);
              var products = pageBean["content"];
              for (var i = 0; i < products.length; i++) {
                  var html = "<tr>";
                  html += "<td>" + products[i].id + "</td>";
                  html += "<td>" + products[i].name + "</td>";
                  html += "<td>" + products[i].count + "</td>";
                  html += "<td>" + products[i].price + "</td>";
                  html += "</tr>";
                  $("#table").append(html);
              }
              pagination(pageBean);
          }, "json");
      }

      /**
       * 生成分页条
       * @pageBean 页面数据对象
       */
      function pagination(pageBean) {
          var page = pageBean.page;
          var totalPage = pageBean.totalPage;

          // 处理分页条起始与总数
          var startPage;
          if (totalPage - page <= 3) {
              startPage = totalPage - 4 < 1 ? 1 : totalPage - 4;
          } else {
              startPage = page - 2 < 1 ? 1 : page - 2;
          }
          var loop;
          if (totalPage < 5) {
              loop = totalPage;
          } else {
              loop = 5;
          }
          // 生成分页条
          var html = "";
          for (var i = startPage; i < startPage + loop; i++) {
              // 当前页高亮
              if (page === i) {
                  html += "<li class='active'><a href='javascript:void(0)'"
              } else {
                  html += "<li><a href='javascript:void(0)'";
              }
              html += "onclick = 'getProducts(" + i + "," + pageBean.pageSize + ")'>";
              html += (i + "</a></li>");
          }
          // 清空分页条数字
          $("#ul li:not(:first,:last)").remove();
          // 填充分页条数字
          $("#ul>li:first").after(html);

          // 上/下翻页按钮
          var previous = $("#previous");
          var next = $("#next");
          previous.unbind("click");
          next.unbind("click");
          if (page === 1) {
              previous.addClass("disabled")
          } else {
              previous.removeAttr("class");
              previous.click(function () {
                  getProducts(page - 1, pageBean.pageSize);
              })
          }
          if (page === totalPage) {
              next.addClass("disabled");
          } else {
              next.removeAttr("class");
              next.click(function () {
                  getProducts(page + 1, pageBean.pageSize);
              })
          }
      }
  </Script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-8 col-md-offset-2">
      <table id="table" class="table table-bordered table-hover">
        <tbody>
        <tr>
          <th>编号</th>
          <th>商品</th>
          <th>数量</th>
          <th>价格</th>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <nav aria-label="Page navigation" class="text-center">
        <ul id="ul" class="pagination">
          <li id="previous"><a href="javascript:void(0)" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span></a>
          </li>

          <li id="next"><a href="javascript:void(0)" aria-label="Next">
            <span aria-hidden="true">&raquo;</span></a>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</div>
</body>
</html>

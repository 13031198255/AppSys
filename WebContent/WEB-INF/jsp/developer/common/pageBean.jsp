<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-sm-5">
		<div class="dataTables_info" id="datatable-responsive_info"
			role="status" aria-live="polite">共${pageBean.totalCount }条记录
			${pageBean.currentPageNo }/${pageBean.totalPage }页</div>
	</div>
	<div class="col-sm-7">
		<div class="dataTables_paginate paging_simple_numbers"
			id="datatable-responsive_paginate">
			<ul class="pagination">
				<c:if test="${pageBean.currentPageNo > 1}">
					<li class="paginate_button previous"><a
						href="javascript:page_nav(document.forms[0],1);"
						aria-controls="datatable-responsive" data-dt-idx="0" tabindex="0">首页</a>
					</li>
					<li class="paginate_button "><a
						href="javascript:page_nav(document.forms[0],${pageBean.currentPageNo-1});"
						aria-controls="datatable-responsive" data-dt-idx="1" tabindex="0">上一页</a>
					</li>
				</c:if>
				<c:if test="${pageBean.currentPageNo < pageBean.totalPage }">
					<li class="paginate_button "><a
						href="javascript:page_nav(document.forms[0],${pageBean.currentPageNo+1 });"
						aria-controls="datatable-responsive" data-dt-idx="1" tabindex="0">下一页</a>
					</li>
					<li class="paginate_button next"><a
						href="javascript:page_nav(document.forms[0],${pageBean.totalPage });"
						aria-controls="datatable-responsive" data-dt-idx="7" tabindex="0">最后一页</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
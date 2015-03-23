﻿<%@ Page Language="C#" AutoEventWireup="true" CodeFile="m_banner.aspx.cs" Inherits="admin_m_banner" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="/style/style.css" rel="stylesheet" />
    <link href="/style/css.css" rel="stylesheet" />
    <link href="/style/layer.css" rel="stylesheet" />
    <link href="style/admin.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
        <div class="g-div-e">
            <div>
                <a class="inpbbut1" id="btn_addmodule" href="m_banner_edit.aspx">新建</a>
            </div>
            <div class="m-table">
                <table>
                    <thead>
                        <tr>
                            <th>操作</th>
                            <th>标题</th>
                            <th>排序</th>
                            <th>图片</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (DtBanner != null && DtBanner.Rows.Count > 0)
                            {
                                foreach (System.Data.DataRow item in DtBanner.Rows)
                                {
                        %><tr class="j-item">
                            <td><a class="inpbbut1" href="m_banner_edit.aspx?id=<%=item["ID"] %>">编辑</a></td>
                            <td><%=item["Title"] %></td>
                            <td><%=item["ShowIndex"] %></td>
                            <td>
                                <img id="img-adres" data-type="1" style="width: 50px; height: 50px;" src="<%=item["ImgAddress"] %>" onerror="this.onerror=null;this.src='/images/nophoto1.jpg'" alt="昱晶科技发展有限公司" title="昱晶科技发展有限公司" />
                            </td>
                        </tr>
                        <%   }
                            }
                            else
                            {
                        %><tr>
                            <td>咱无轮播图片</td>
                        </tr>
                        <%
                            } 
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</body>
</html>

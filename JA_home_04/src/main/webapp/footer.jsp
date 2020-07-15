<%-- <%@ page import = "beans" %> --%>
<jsp:useBean id="magazineList" class="ua.lviv.lgs.MagazineBeans"/>

<link rel="stylesheet" href="style.css">
<h3>Magazine</h3>

<br>

<%
	System.out.println("index");
	int limitVisible = 30;
	
	
	magazineList.readLimitMagazine(0, limitVisible);
	
	for (int i = 0; i < limitVisible; i++) {
		if (magazineList.readNameMagazine(i) != null){
			out.println("<div>");
			
			out.println("<span style=\"color: blue; font-size:24px\">");
			out.println(magazineList.readNameMagazine(i));	
			out.println("</span>");
			out.println("<br>");
			
			out.println("  isbn: " + magazineList.readIsbnMagazine(i));
			out.println(",  description: " + magazineList.readDescriptionMagazine(i));			
			out.println(",  price: " + magazineList.readPriceMagazine(i) + "<br>");
			out.println("<br>");
			
			/* out.println("<a href = \"\"> link" + i + "</a>"); */
			if(magazineList.visibleCheckBox()){
				out.println("<label><input type=\"checkbox\" name =\"checkb\"> <span>Subscribe</span></label> <br>");
			}
			out.println("</div>");
			out.println("<br><br>");
		}
	}
	
	out.println(magazineList.countAllMagazine());
%>	
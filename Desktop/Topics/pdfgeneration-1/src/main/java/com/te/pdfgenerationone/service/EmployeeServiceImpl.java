package com.te.pdfgenerationone.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.te.pdfgenerationone.entity.Employee;
import com.te.pdfgenerationone.repository.EmployeeRepo;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	@Override
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);

		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle.setSize(10);

		Paragraph paragraph = new Paragraph("This is a title", fontTitle);
		paragraph.setAlignment(paragraph.ALIGN_CENTER);

		Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
		fontParagraph.setSize(12);

		Paragraph paragraph2 = new Paragraph("This a para.", fontParagraph);
		paragraph2.setAlignment(paragraph2.ALIGN_LEFT);

		document.add(paragraph);
		document.add(paragraph2);
		document.close();
	}

	@Override
	public Document exportEmpl(HttpServletResponse response) {

		Document document = new Document(PageSize.A2);
		List<Employee> findAll = repo.findAll();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			fontTitle.setSize(20);

			Paragraph paragraph1 = new Paragraph("Employee Table", fontTitle);
			paragraph1.setAlignment(paragraph1.ALIGN_CENTER);

			PdfPTable table = new PdfPTable(4);

			// Setting width of the table, its columns and spacing
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 3, 3, 3, 3 });
			table.setSpacingBefore(5);

			// Create Table Cells for the table header
			PdfPCell cell = new PdfPCell();
			// Setting the background color and padding of the table cell
			cell.setBackgroundColor(CMYKColor.BLUE);
			cell.setPadding(5);
			// Setting font style and size
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			font.setColor(CMYKColor.WHITE);

			// Adding headings in the created table cell or header
			// Adding Cell to table
			cell.setPhrase(new Phrase("ID", font));
			cell.setBorder(2);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Student Name", font));
			cell.setBorder(2);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Age", font));
			cell.setBorder(2);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell.setPhrase(new Phrase("Password", font));
			cell.setBorder(2);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);

			findAll.stream().forEach(employee -> {
				table.addCell(String.valueOf(employee.getEmployeeId()));
				table.addCell(employee.getEmployeeName());
				table.addCell(String.valueOf(employee.getAge()));
				table.addCell(employee.getPassword());
			});

			Paragraph paragraph2 = new Paragraph("Employee Table", fontTitle);
			document.add(paragraph1);
			document.add(table);

			document.close();

			return document;

		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;

	}

}

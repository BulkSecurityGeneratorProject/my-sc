package zw.co.elearning.school.reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.NotSupportedException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Component
public class ReportGeneratorImpl implements ReportGenerator {

	List<ReportSource<?>> reportSources = new ArrayList<>();

	@Override
	public List<String> reportsGroups() {
		List<String> result = new ArrayList<>();

		reportSources.forEach((source) -> {
			if (!result.contains(source.getGroup())) {
				result.add(source.getGroup());
			}
		});

		// result.sort(Collections.ord);

		return result;
	}

	@Override
	public List<Map<String, String>> reportsInGroup(String group) {
		List<Map<String, String>> result = new ArrayList<>();

		reportSources.forEach((source) -> {
			if (source.getGroup().equalsIgnoreCase(group)) {
				Map<String, String> entry = new HashMap<>();

				entry.put("id", source.getId());
				entry.put("group", source.getGroup());
				entry.put("name", source.getName());
				entry.put("frequency", source.getFrequency().toString());

				result.add(entry);
			}
		});

		// result.sort(Collections.ord);

		return result;
	}

	@Override
	public File generate(String reportId, Date from, Date to, String[] deptIds, String format)
			throws IOException, JRException, NotSupportedException {

		File result = null;

		for (ReportSource<?> source : reportSources) {
			if (source.getId().equals(reportId)) {
				source.generate(from, to, deptIds);
				result = generateReport(source, format);
				break;
			}
		}
		return result;
	}

	private File generateReport(ReportSource<?> reportService, String format)
			throws IOException, JRException, NotSupportedException {

		ClassPathResource resource = new ClassPathResource(reportService.getLayoutTemplateUrl());

		List<ReportSource<?>> data = new ArrayList<>();

		data.add(reportService);

		Map<String, Object> params = new HashMap<>();

		params.put("SUB_REPORT_PATH", reportService.getTemplateUrl());

		JRDataSource dataSource = new JRBeanCollectionDataSource(data, false);

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(resource.getInputStream());

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

		File file = File.createTempFile(reportService.getId(), "." + format);// .getAbsolutePath();

		// String printFileName = JasperFillManager.fillReportToFile
		// (reportService.getTemplate(),
		// reportService.getParams(), dataSource);
		String destinationFile = file.getAbsolutePath();

		switch (format) {
		case "xml":
			JasperExportManager.exportReportToXmlFile(jasperPrint, destinationFile, false);
			break;
		case "html":
			JasperExportManager.exportReportToHtmlFile(jasperPrint, destinationFile);
			break;
		case "pdf":
			JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);
			break;
		case "xls":
		case "xlsx":

			JRXlsxExporter excel = new JRXlsxExporter();

			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();

			excel.setExporterInput(new SimpleExporterInput(jasperPrint));

			excel.setExporterOutput(new SimpleOutputStreamExporterOutput(destinationFile));

			configuration.setDetectCellType(true);// Set configuration as you
													// like it!!
			configuration.setCollapseRowSpan(false);

			excel.setConfiguration(configuration);

			excel.exportReport();

			break;
		case "doc":
		case "docx":

			JRDocxExporter word = new JRDocxExporter();

			word.setExporterInput(new SimpleExporterInput(jasperPrint));

			word.setExporterOutput(new SimpleOutputStreamExporterOutput(destinationFile));

			word.exportReport();

			break;

		case "csv":
		case "rtf":
		case "text":
		case "odt":
		case "ods":
		case "pptx":
		default:
			throw new NotSupportedException(format + " file format not supported by system");
		}

		return file;
	}

	@Override
	public void add(ReportSource<?> reportSource) {
		reportSources.add(reportSource);
	}
}

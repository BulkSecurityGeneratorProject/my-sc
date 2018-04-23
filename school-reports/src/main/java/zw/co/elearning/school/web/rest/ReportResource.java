package zw.co.elearning.school.web.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.NotSupportedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import net.sf.jasperreports.engine.JRException;
import zw.co.elearning.school.reports.ReportGenerator;

@RestController
@RequestMapping(value = "api")
public class ReportResource {

	private final Logger log = LoggerFactory.getLogger(ReportResource.class);

	@Autowired
	ReportGenerator reportGenerator;

	@GetMapping("/reports/report-groups")
	@Timed
	public ResponseEntity<List<String>> getReportGroups() throws URISyntaxException {
		log.debug("REST request to get a list of report group");
		List<String> result = reportGenerator.reportsGroups();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/reports/report-groups/{group}")
	@Timed
	public ResponseEntity<List<Map<String, String>>> getGroupReports(@PathVariable("group") String group)
			throws URISyntaxException {
		log.debug("REST request to get a list of reports in group {}", group);
		List<Map<String, String>> result = reportGenerator.reportsInGroup(group);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/reports/{id}")
	@Timed
	public @ResponseBody ResponseEntity<InputStreamResource> generate(@PathVariable("id") String id,
			@RequestParam(required = true, value = "from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
			@RequestParam(required = true, value = "to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
			@RequestParam(required = false, value = "deptId") String[] deptIds,
			@RequestParam(required = false, value = "format", defaultValue = "pdf") String format)
			throws IOException, JRException, NotSupportedException {

		File file = reportGenerator.generate(id, from, to, deptIds, format);

		InputStream reportStream = new FileInputStream(file);

		HttpHeaders responseHeaders = new HttpHeaders();

		InputStreamResource inputStreamResource = new InputStreamResource(reportStream);

		responseHeaders.setContentLength(file.length());
		responseHeaders.setContentType(MediaType.valueOf("application/" + format));

		return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeaders, HttpStatus.OK);
	}

}
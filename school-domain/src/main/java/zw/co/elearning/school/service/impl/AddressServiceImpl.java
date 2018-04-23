package zw.co.elearning.school.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Multiset.Entry;

import zw.co.elearning.school.domain.Address;
import zw.co.elearning.school.repository.AddressRepository;
import zw.co.elearning.school.service.AddressService;
import zw.co.elearning.school.service.dto.AddressDTO;
import zw.co.elearning.school.service.mapper.AddressMapper;

/**
 * Service Implementation for managing Address.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	private final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	private final AddressRepository addressRepository;

	private final AddressMapper addressMapper;

	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	/**
	 * Save a address.
	 *
	 * @param addressDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public AddressDTO save(AddressDTO addressDTO) {
		log.debug("Request to save Address : {}", addressDTO);
		Address address = addressMapper.addressDTOToAddress(addressDTO);
		address = addressRepository.save(address);
		AddressDTO result = addressMapper.addressToAddressDTO(address);
		return result;
	}

	/**
	 * Get all the addresses.
	 * 
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<AddressDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Addresses");
		Page<Address> result = addressRepository.findAll(pageable);
		return result.map(address -> addressMapper.addressToAddressDTO(address));
	}

	/**
	 * Get one address by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public AddressDTO findOne(String id) {
		log.debug("Request to get Address : {}", id);
		Address address = addressRepository.findOne(id);
		AddressDTO addressDTO = addressMapper.addressToAddressDTO(address);
		return addressDTO;
	}

	/**
	 * Delete the address by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(String id) {
		log.debug("Request to delete Address : {}", id);
		addressRepository.delete(id);
	}

	@Override
	public List<Map<String, Object>> findByPersonId(String personId) {
		List<Map<String, Object>> result = new ArrayList<>();

		List<Address> addresses = addressRepository.findByPersonId(personId);

		addresses.forEach(address -> {

			Map<String, Object> entry = new HashMap<>();

			entry.put("city", address.getCity());
			entry.put("street", address.getStreet());
			entry.put("town", address.getTown());
			entry.put("id", address.getId());
			entry.put("personId", address.getPerson().getId());

			result.add(entry);
		});

		return result;
	}
}

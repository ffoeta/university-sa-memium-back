package com.degenerates.memium.facade;

import com.degenerates.memium.model.dto.AccountShortDto;
import com.degenerates.memium.model.relations.SubList;
import com.degenerates.memium.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SubFacade {

    @Autowired
    SubService subService;

    @Autowired
    AccountShortService accountShortService;

    public ResponseEntity<List<AccountShortDto>> getSubOfAccount(UUID accountId) {
        List<UUID> accountIds = subService.getAccountSubbedBy(accountId);
        List<AccountShortDto> accountShortDtoList = accountShortService.getAccountsByIds(accountIds);
        return ResponseEntity.ok(accountShortDtoList);
    }
}

package lk.ijse.thogakadepos_backend.customStatusCodes;

import lk.ijse.thogakadepos_backend.dto.CustomerStatus;
import lk.ijse.thogakadepos_backend.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerAndItemErrorStatus implements CustomerStatus, ItemStatus {
    private int statusCode;
    private String statusMessage;
}

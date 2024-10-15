package lk.ijse.thogakadepos_backend.customStatusCodes;

import lk.ijse.thogakadepos_backend.dto.OrderDetailStatus;

public class SelectedOrderDetailErrorStatus implements OrderDetailStatus {
    private int statusCode;
    private String statusMessage;
}

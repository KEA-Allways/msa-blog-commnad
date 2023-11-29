package com.allways.domain.reply.controller;

import com.allways.domain.reply.dto.ReplyCreateRequest;
import com.allways.domain.reply.dto.ReplyUpdateRequest;
import com.allways.domain.reply.service.ReplyCommandService;
import com.allways.common.response.Response;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyCommandController {
    private final ReplyCommandService replyCommandService;

    @PostMapping("/api/post/{postSeq}/reply")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createReply(@PathVariable Long postSeq,
                                @RequestHeader(value = "userSeq") Long userSeq,
                                @RequestBody ReplyCreateRequest req) {
        replyCommandService.createReply(req, postSeq, userSeq);
        return Response.success();
    }

    @PutMapping("/api/post/reply/{replySeq}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateReply(@PathVariable Long replySeq, @RequestBody ReplyUpdateRequest req){
        replyCommandService.updateReply(replySeq, req);
        return Response.success();
    }

    @DeleteMapping("/api/post/reply/{replySeq}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteReply(@PathVariable Long replySeq) {
        replyCommandService.deleteReply(replySeq);
        return Response.success();
    }
}
